/*
 * Copyright 2015 Ismael Toé
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ismaeltoe.osms.library.entities.contract;

public class ServiceContract {

    private String country;
    private String service;
    private String contractId;
    private int availableUnits;
    private String expires;
    private String scDescription;

    public String getCountry() {
        return country;
    }

    public String getService() {
        return service;
    }

    public String getContractId() {
        return contractId;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public String getExpires() {
        return expires;
    }

    public String getScDescription() {
        return scDescription;
    }
}
