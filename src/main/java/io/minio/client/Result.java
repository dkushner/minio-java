/*
 * Minimal Object Storage Library, (C) 2015 Minio, Inc.
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

package io.minio.client;

import io.minio.client.errors.ClientException;

import java.io.IOException;

public class Result<T> {
    private T t;
    private Exception e;
    public Result(T t, Exception e) {
        this.t = t;
        this.e = e;
    }

    public T getResult() throws IOException, ClientException {
        if(e != null) {
            if(e instanceof IOException) {
                throw (IOException)e;
            }
            if(e instanceof ClientException) {
                throw (ClientException)e;
            }
        }
        return t;
    }
}
