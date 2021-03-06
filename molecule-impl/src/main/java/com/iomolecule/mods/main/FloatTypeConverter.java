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

package com.iomolecule.mods.main;

import com.iomolecule.system.TypeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class FloatTypeConverter implements TypeConverter{
    @Override
    public Object convert(Object in) {
        Float value = null;
        if(in != null) {
            if(in instanceof Float){
                value = (Float)in;
            }else if (in instanceof String){
                String floatString = (String)in;
                try {
                    value = new Float(floatString);
                }catch(Exception e){
                    log.warn("Unable to convert {} to type {}",floatString,Float.class);
                }
            }else{
                log.warn("Unsupported source type {}. Cannot convert to type {}",in.getClass(),Float.class);
            }
        }
        return value;
    }
}
