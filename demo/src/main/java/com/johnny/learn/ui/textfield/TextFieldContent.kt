package com.johnny.learn.ui.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnny.learn.entity.MainListDto
import com.johnny.learn.util.ext.TitleComponent

@Composable
fun TextFieldContent() {
    /**
     * 默认会滚动
     *
     * 旧版本用这俩个 ScrollableRow 和 ScrollableColumn 新版本api已经被LazyColumn和 LazyRow取代
     */
    LazyColumn {
        item {
            MaterialTextInputComponent(showTxt = "普通输入框")
        }
        item {
            MaterialTextInputComponent(
                showTxt = "密码输入框",
                visualTransformation = PasswordVisualTransformation()
            )
        }
        item {
            MaterialTextInputComponent(
                showTxt = "数字输入框",
                imeOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        item {
            var imeOptions = KeyboardOptions(imeAction = ImeAction.Search)
            MaterialTextInputComponent(
                showTxt = "回车按钮自定义输入框",
                imeOptions = imeOptions,
            )
        }
    }

}


@Composable
fun MaterialTextInputComponent(
    keyboardActions: KeyboardActions = KeyboardActions(),
    imeOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    showTxt: String
) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    var tempVtf = visualTransformation

    /*
    属性一览

    value: String
    输入框中要显示的文本；
    value: TextFieldValue
    输入框中要显示的文本，包含了输入框编辑状态的信息，这个功能很强大，可以用来更新文本，光标等，然后还可以从其他位置直接观察到这些值的变化。也就是相当于双向绑定的意思；
    onValueChange: (TextFieldValue) -> Unit
    输入服务更新TextFieldValue中的值时触发的回调，更新后的TextFieldValue值作为回调参数；
    modifier: Modifier = Modifier
    修饰符
    textStyle: TextStyle = AmbientTextStyle.current
    应用于输入框的样式，默认样式为AmbientTextStyle.current
    label: () -> Unit = null
    显示在文本字段内的可选标签，类似于占位符，但是是输入框没有获得焦点时候的占位符。下文代码中用实例讲解下会很好理解；
    placeholder: () -> Unit = null
    当输入框获得焦点的时候，要展示的占位符，文本样式默认为Text的Typography.subtitle1
    leadingIcon: () -> Unit = null
    trailingIcon: () -> Unit = null
    输入框前后要展示的图标；
    isErrorValue: Boolean = false
    表示输入框中的内容是否处于失败的状态，如果为true，则label，Icon等会相应的展示错误的显示状态；
    visualTransformation: VisualTransformation = VisualTransformation.None
    转换输入值的视觉表示。例如，您可以使用androidx.compose.ui.text.input.PasswordVisualTransformation创建密码文本字段，也就是输入的密码字符串会转换为 ······ 显示。默认情况下，不应用任何视觉转换；
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
    包含配置的软件键盘选项，例如KeyboardType和ImeAction。
    singleLine: Boolean = false
    当设置为true时，此文本字段将变为单个水平滚动文本字段，而不是多行。
    maxLines: Int = Int.MAX_VALUE
    以最大可见行数表示的最大高度，该值需要等于或大于1。如果将singleLine设置为true，则将忽略此参数，而将maxLines设置为1。
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> }
    输入服务执行ImeAction时触发。请注意，发出的IME操作可能与您通过KeyboardOptions.imeAction字段指定的操作不同。回调还公开了SoftwareKeyboardController实例作为可用于请求隐藏软件键盘的参数；
    onTextInputStarted: (SoftwareKeyboardController) -> Unit = {}
    建立与平台的文本输入服务（例如Android上的软件键盘）的连接时要调用的回调。可用于请求显示或隐藏软件键盘；
    interactionState: InteractionState = remember { InteractionState() }
    暂时不清楚用法
    activeColor: Color = MaterialTheme.colors.primary
    输入框处于焦点时的标签，底部指示符和光标的颜色；
    inactiveColor: Color = MaterialTheme.colors.onSurface
    输入框处于焦点时的输入文本或占位符的颜色，输入框不处于焦点时的标签和底部指示符的颜色；
    errorColor: Color = MaterialTheme.colors.error
    将isErrorValue设置为true时使用的标签，底部指示器，光标和尾随图标的颜色；
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha)
    输入框的背景色；
    shape: Shape = MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize)
    输入框的形状；
     */
    TextField(
        value = textValue,
        keyboardOptions = imeOptions,
        keyboardActions = keyboardActions,
        onValueChange = { textValue = it },
        placeholder = { Text(text = showTxt) },
        visualTransformation = tempVtf,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}