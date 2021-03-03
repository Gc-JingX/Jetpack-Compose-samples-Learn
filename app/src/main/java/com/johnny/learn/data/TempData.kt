/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.johnny.learn.data

import com.johnny.learn.entity.MainListDto
import com.johnny.learn.ui.main.state.MainUiState


private val initMainDatas = listOf(
    MainListDto(0, "文本"),
    MainListDto(1, "按钮"),
    MainListDto(2, "输入框"),
    MainListDto(3, "布局"),
)

val exampleMainUiState = MainUiState(
    initMainDatas = initMainDatas,
)

