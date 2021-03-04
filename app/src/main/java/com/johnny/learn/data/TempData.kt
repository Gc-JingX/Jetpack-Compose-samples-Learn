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
import com.johnny.learn.ui.button.ButtonViewActivity
import com.johnny.learn.ui.dataview.DataView1Activity
import com.johnny.learn.ui.image.ImageViewActivity
import com.johnny.learn.ui.layout.BoxActivity
import com.johnny.learn.ui.layout.ColumActivity
import com.johnny.learn.ui.layout.ConstraintActivity
import com.johnny.learn.ui.layout.RowActivity
import com.johnny.learn.ui.main.state.MainUiState
import com.johnny.learn.ui.text.TextViewActivity
import com.johnny.learn.ui.textfield.TextFieldActivity


private val initMainDatas = listOf(
    MainListDto(0, "文本", TextViewActivity::class.java),
    MainListDto(1, "按钮", ButtonViewActivity::class.java),
    MainListDto(2, "输入框", TextFieldActivity::class.java),
    MainListDto(3, "图片", ImageViewActivity::class.java),
    MainListDto(4, "页面数据更新", DataView1Activity::class.java),
    MainListDto(5, "约束布局", ConstraintActivity::class.java),
    MainListDto(6, "横向布局", RowActivity::class.java),
    MainListDto(7, "纵向布局", ColumActivity::class.java),
    MainListDto(8, "Box布局", BoxActivity::class.java),
)

val exampleMainUiState = MainUiState(
    initMainDatas = initMainDatas,
)


