/*
 * Copyright (C) 2018-2020. Huawei Technologies Co., Ltd. All rights reserved.
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
package io.prestosql.spi.heuristicindex;

import io.prestosql.spi.filesystem.HetuFileSystemClient;

import java.nio.file.Path;
import java.util.Properties;

public interface IndexFactory
{
    /**
     * Creates an IndexWriter configured with config files, HetuFileSystemClient and root Path
     * tableName + configRoot/catalog -> dsProperty
     * configRoot/config.properties -> ixProperty
     *
     * @param dataSourceProps properties for datasource
     * @param indexProps properties for index
     * @param fs filesystem client to read index
     * @param root path to the index root folder
     * @return Returns the IndexWriter loaded with the corresponding DataSource, Index and filesystem client
     */
    public IndexWriter getIndexWriter(Properties dataSourceProps, Properties indexProps, HetuFileSystemClient fs, Path root);

    /**
     * Creates an IndexClient configured with the IndexStore using the provided filesystem client and root folder.
     *
     * @param fs filesystem client to read index
     * @param root path to the index root folder
     * @return An IndexClient which has the IndexStore configured
     */
    public IndexClient getIndexClient(HetuFileSystemClient fs, Path root);
}