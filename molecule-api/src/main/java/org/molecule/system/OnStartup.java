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

package org.molecule.system;

/**
 * On Startup represents the extension point exposed by the services in Molecule System
 * to get a call back when the system is starting up.
 */
public interface OnStartup {

    /**
     * Call back to inform the interested party of system startup.
     * @param args The arguments passed when starting the system
     */
    public void onStart(String[] args);

}
