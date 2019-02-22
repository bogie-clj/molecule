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

package com.iomolecule.mods.sqljdbi;

import com.iomolecule.sql.jdbi.services.SQLJDBIManagerService;
import com.iomolecule.system.LifecycleException;
import com.iomolecule.system.LifecycleManager;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
class SQLJDBILifecycleManager implements LifecycleManager{

    private SQLJDBIManagerService managerService;


    @Inject
    SQLJDBILifecycleManager(SQLJDBIManagerService sqljdbiManagerService){
        managerService = sqljdbiManagerService;
    }

    @Override
    public void start() throws LifecycleException {
        log.debug("Starting...");
        managerService.start();
    }

    @Override
    public void stop() {
        log.debug("Stopping...");

        managerService.stop();
    }

    @Override
    public int getOrder() {
        return DEFAULT_ORDER + 10;
    }
}
