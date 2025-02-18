/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.computer.core.combiner;

import java.util.Map;

import org.apache.hugegraph.computer.core.graph.properties.Properties;
import org.apache.hugegraph.computer.core.graph.value.Value;
import org.apache.hugegraph.util.E;

public class MergeNewPropertiesCombiner implements PropertiesCombiner {

    /**
     * Merge properties v2 and v1 into result. If a property exists in both v1
     * and v2, remain the value in v1.
     */
    @Override
    public void combine(Properties v1, Properties v2, Properties result) {
        E.checkArgumentNotNull(v1, "The combine parameter v1 can't be null");
        E.checkArgumentNotNull(v2, "The combine parameter v2 can't be null");
        E.checkArgumentNotNull(result,
                               "The combine parameter result can't be null");
        E.checkArgument(v1 != result && v2 != result,
                        "The combine parameter result " +
                        "can't same with v1 or v2");

        result.clear();

        Map<String, Value> v1Map = v1.get();
        for (Map.Entry<String, Value> entry : v1Map.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        Map<String, Value> v2Map = v2.get();
        for (Map.Entry<String, Value> entry : v2Map.entrySet()) {
             result.putIfAbsent(entry.getKey(), entry.getValue());
        }
    }
}
