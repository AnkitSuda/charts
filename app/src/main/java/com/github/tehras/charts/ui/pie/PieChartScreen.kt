package com.github.tehras.charts.ui.pie

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer
import com.github.tehras.charts.theme.Margins
import com.github.tehras.charts.ui.ChartScreenStatus

@Composable
fun PieChartScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ChartScreenStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
                title = { Text(text = "Pie Chart") }
            )
        },
        bodyContent = { PieChartScreenContent() }
    )
}

@Composable
private fun PieChartScreenContent() {
    val pieChartDataModel = remember { PieChartDataModel() }

    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        PieChartRow(pieChartDataModel)
        SliceThicknessRow(pieChartDataModel.sliceThickness) {
            pieChartDataModel.sliceThickness = it
        }
        AddOrRemoveSliceRow(pieChartDataModel)
    }
}

@Composable
private fun PieChartRow(pieChartDataModel: PieChartDataModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = Margins.vertical)
    ) {
        PieChart(
            pieChartData = pieChartDataModel.pieChartData,
            sliceDrawer = SimpleSliceDrawer(
                sliceThickness = pieChartDataModel.sliceThickness
            )
        )
    }
}

@Composable
private fun SliceThicknessRow(sliceThickness: Float, onValueUpdated: (Float) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Margins.verticalLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Slice thickness",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = Margins.horizontal)
        )
        Slider(
            value = sliceThickness,
            onValueChange = { onValueUpdated(it) },
            valueRange = 10f.rangeTo(100f)
        )
    }
}

@Composable
private fun AddOrRemoveSliceRow(pieChartDataModel: PieChartDataModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Margins.vertical),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            enabled = pieChartDataModel.slices.size > 3,
            onClick = { pieChartDataModel.removeSlice() },
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Remove)
        }
        Row(
            modifier = Modifier.padding(horizontal = Margins.horizontal),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Slices: ")
            Text(
                text = pieChartDataModel.slices.count().toString(),
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            )
        }
        Button(
            enabled = pieChartDataModel.slices.size < 9,
            onClick = { pieChartDataModel.addSlice() },
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Add)
        }
    }
}

@Preview
@Composable
fun PieChartScreenPreview() = PieChartScreen()