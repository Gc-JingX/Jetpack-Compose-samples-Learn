package com.johnny.learn.ui.dataview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DataView1Content() {
    Column(modifier = Modifier.fillMaxWidth()) {
        CustomStyledText()
    }

}

data class CounterState(val counter: Int = 0)
@Composable
fun CustomStyledText() {
    //在Compose函数中可以直接监听到数据变化，自动更新显示，
    var counterState by remember { mutableStateOf(CounterState()) }
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            elevation = ButtonDefaults.elevation(5.dp),
            onClick = {
                counterState = counterState.copy(counter = counterState.counter + 1)
            }) {
            Text(text = "变更", modifier = Modifier.padding(16.dp))
        }
        Button(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            elevation = ButtonDefaults.elevation(5.dp),
            onClick = {
                counterState = counterState.copy(counter = 0)
            }) {
            Text(text = "重置", modifier = Modifier.padding(16.dp))
        }
    }
    // This text composable is just used to display the current value of the counter.
    Text(text = "变化后为->> ${counterState.counter}", modifier = Modifier.padding(16.dp))

}