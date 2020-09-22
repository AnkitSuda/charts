package com.github.tehras.charts.ui.line


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.theme.Margins.horizontal
import com.github.tehras.charts.theme.Margins.vertical
import com.github.tehras.charts.theme.Margins.verticalLarge
import com.github.tehras.charts.ui.ChartScreenStatus
import com.github.tehras.charts.ui.line.LineChartDataModel.PointDrawerType

@Composable
fun LineChartScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ChartScreenStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
                title = { Text(text = "Line Chart") }
            )
        },
        bodyContent = { LineChartScreenContent() }
    )
}

@Composable
fun LineChartScreenContent() {
    val lineChartDataModel = LineChartDataModel()

    Column(
        modifier = Modifier.padding(
            horizontal = horizontal,
            vertical = vertical
        )
    ) {
        LineChartRow(lineChartDataModel)
        HorizontalOffsetSelector(lineChartDataModel)
        OffsetProgress(lineChartDataModel)
    }
}

@Composable
fun HorizontalOffsetSelector(lineChartDataModel: LineChartDataModel) {
    val selectedType = lineChartDataModel.pointDrawerType

    Row(
        modifier = Modifier.padding(
            horizontal = horizontal,
            vertical = verticalLarge
        ),
        verticalAlignment = CenterVertically
    ) {
        Text("Point Drawer")

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = horizontal, vertical = vertical)
                .align(CenterVertically)
        ) {
            PointDrawerType.values().forEach { type ->
                val color = if (selectedType == type) {
                    Color.Black
                } else {
                    Color.Transparent
                }

                TextButton(
                    border = BorderStroke(2.dp, SolidColor(color)),
                    onClick = { lineChartDataModel.pointDrawerType = type }
                ) {
                    Text(type.name)
                }
            }
        }
    }
}

@Composable
fun OffsetProgress(lineChartDataModel: LineChartDataModel) {
    Row(
        modifier = Modifier.padding(horizontal = horizontal),
        verticalAlignment = CenterVertically
    ) {
        Text("Offset")

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
                .align(CenterVertically)
        ) {
            Slider(
                value = lineChartDataModel.horizontalOffset,
                onValueChange = { lineChartDataModel.horizontalOffset = it },
                valueRange = 0f.rangeTo(25f)
            )
        }
    }
}

@Composable
fun LineChartRow(lineChartDataModel: LineChartDataModel) {
    Box(modifier = Modifier.height(250.dp).fillMaxWidth()) {
        LineChart(
            lineChartData = lineChartDataModel.lineChartData,
            horizontalOffset = lineChartDataModel.horizontalOffset,
            pointDrawer = lineChartDataModel.pointDrawer
        )
    }
}


@Preview
@Composable
fun LineChartPreview() = LineChartScreen()