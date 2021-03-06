/*
 * Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
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
package io.helidon.svm;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import io.helidon.config.Config;
import io.helidon.config.spi.PollingStrategy;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

/**
 * Graal VM substitutions for Config.
 */
public final class ConfigSubstitutions {
    @TargetClass(className = "io.helidon.config.spi.PollingStrategyConfigMapper")
    static final class ConfigMapperSvmExtension {
        @Substitute
        private <T> Optional<Function<T, Supplier<PollingStrategy>>> custom(Class<?> clazz,
                                                                            Config properties,
                                                                            Class<T> targetType) {
            return Optional.empty();
        }
    }
}
