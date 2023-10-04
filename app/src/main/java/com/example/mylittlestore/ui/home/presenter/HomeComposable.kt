package com.example.mylittlestore.ui.home.presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylittlestore.data.dto.ProductModel
import com.example.mylittlestore.ui.home.viewModel.ProductViewModel
import com.example.mylittlestore.ui.home.viewModel.ProductViewModelEvent
import com.example.mylittlestore.utils.isInternetAvailable

@Composable
fun ShowHomeView() {
    val context = LocalContext.current
    val viewModel: ProductViewModel = viewModel()

    val data by viewModel.state.collectAsState()

    viewModel.getProducts(isInternetAvailable(context))
    when (data){
        is ProductViewModelEvent.StateError ->{
            ShowErrorView((data as ProductViewModelEvent.StateError).message,viewModel)
        }

        is ProductViewModelEvent.StateSuccess ->{
            ShowSuccessView((data as ProductViewModelEvent.StateSuccess).data)
        }

        else -> {}
    }
}

@Composable
private fun ShowSuccessView(data: ProductModel) {

    Box(modifier = Modifier.fillMaxSize()){
        Text(text = data.toString(), fontSize = 35.sp)
    }
}

@Composable
private fun ShowErrorView(message : String, viewModel: ProductViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            viewModel.getProducts(true)
        }){
        Text(text = message)
    }
}
