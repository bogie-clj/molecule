/*
 * Copyright 2019 Vijayakumar Mohan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iomolecule.mods.httpshell;

import com.iomolecule.shell.http.HttpShellConfig;
import com.iomolecule.system.Shell;
import io.undertow.Undertow;
import io.undertow.server.handlers.BlockingHandler;
import io.undertow.server.HttpHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Slf4j
class HttpShellImpl implements Shell{

    private HttpShellConfig httpShellConfig;
    private Undertow undertow;
    private HttpHandler mainHandler;

    @Inject
    HttpShellImpl(HttpShellConfig httpShellConfig,@Named("main-http-shell-handler") HttpHandler mainHandler){
        Objects.requireNonNull(httpShellConfig,"http shell config");
        Objects.requireNonNull(mainHandler,"main http handler");
        this.httpShellConfig = httpShellConfig;
        this.mainHandler = mainHandler;
    }

    @Override
    public void start(String[] args) {
        log.debug("Starting....");

        Undertow.Builder httpShellBuilder = Undertow.builder().addHttpListener(httpShellConfig.getPort(), httpShellConfig.getBindAddress());
        httpShellBuilder.setHandler(new BlockingHandler(mainHandler));
        undertow = httpShellBuilder.build();

        undertow.start();
    }

    @Override
    public void updateState() {

    }

    @Override
    public void stop() {
        log.debug("Stopping...");


        if(undertow != null){
            undertow.stop();
        }
    }
}
