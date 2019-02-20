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

package com.iomolecule.util;

import com.iomolecule.system.Ordered;

import java.util.Comparator;

public class OrderComparator implements Comparator<Ordered> {
    @Override
    public int compare(Ordered o1, Ordered o2) {
        int output = 0;
        if(o1.getOrder() < o2.getOrder()){
            output = -1;
        }else if(o1.getOrder() > o2.getOrder()){
            output = 1;
        }
        return output;
    }
}
