package com.ngga_ring.aplikasimobileapppromo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.ngga_ring.aplikasimobileapppromo.data.extensi.toJson
import com.ngga_ring.aplikasimobileapppromo.data.models.PromoModels
import com.ngga_ring.aplikasimobileapppromo.data.viewModels.PromoViewModel
import com.ngga_ring.aplikasimobileapppromo.ui.theme.AplikasiMobileAppPromoTheme
import com.ngga_ring.aplikasimobileapppromo.ui.view.DataItemView
import com.ngga_ring.aplikasimobileapppromo.ui.view.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: PromoViewModel = viewModel()
            // Get the JSON data from the intent
            val selectedItemJson = intent.getStringExtra("selectedItem")

            // Convert JSON to Item object
            val selectedItem = Gson().fromJson(selectedItemJson, PromoModels::class.java)
            AplikasiMobileAppPromoTheme {
                Column(modifier = Modifier.padding(8.dp)) {
                    DataItemView(selectedItem)
                }

            }
        }
    }
}

