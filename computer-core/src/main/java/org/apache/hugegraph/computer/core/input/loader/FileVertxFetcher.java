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

package org.apache.hugegraph.computer.core.input.loader;

import java.util.ArrayList;
import java.util.List;

import org.apache.hugegraph.computer.core.config.Config;
import org.apache.hugegraph.computer.core.input.VertexFetcher;
import org.apache.hugegraph.loader.builder.ElementBuilder;
import org.apache.hugegraph.loader.builder.VertexBuilder;
import org.apache.hugegraph.loader.executor.LoadContext;
import org.apache.hugegraph.loader.mapping.InputStruct;
import org.apache.hugegraph.loader.mapping.VertexMapping;
import org.apache.hugegraph.structure.graph.Vertex;

public class FileVertxFetcher extends FileElementFetcher<Vertex>
                              implements VertexFetcher {

    public FileVertxFetcher(Config config) {
        super(config);
    }

    @Override
    protected List<ElementBuilder<Vertex>> elementBuilders(LoadContext context,
                                                           InputStruct struct) {
        List<ElementBuilder<Vertex>> builders = new ArrayList<>();
        for (VertexMapping mapping : struct.vertices()) {
            if (mapping.skip()) {
                continue;
            }
            builders.add(new VertexBuilder(context, struct, mapping));
        }
        return builders;
    }

    @Override
    public void close() {
        super.close();
    }
}
