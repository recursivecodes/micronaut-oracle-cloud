/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.annotation.Nullable;
import java.util.List;

public interface BucketOperations {
    @Get("/buckets{/compartmentId}")
    Single<List<String>> listBuckets(@Nullable String compartmentId);

    @Post("/buckets/{name}")
    Single<String> createBucket(String name);

    @Delete("/buckets/{name}")
    Single<Boolean> deleteBucket(String name);
}
