package com.ngga_ring.aplikasimobileapppromo.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ngga_ring.aplikasimobileapppromo.data.models.Img
import com.ngga_ring.aplikasimobileapppromo.data.models.PromoModels


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DataItemView(
    data: PromoModels
) {
    Surface(
        // Adjust the size of the box as needed
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${data.id ?: "N/A"}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Title: ${data.Title ?: "N/A"}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "nama: ${data.nama ?: "N/A"}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                // Adjust the size of the box as needed
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Cyan),
                color = Color(android.graphics.Color.parseColor("#c5f1b1"))
            ) {
                Text(modifier = Modifier.padding(8.dp), text = "desc: \n${data.desc ?: "N/A"}", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            data.img?.let { url ->
                Spacer(modifier = Modifier.height(16.dp))
                GlideImage(
                    model = url.url,
                    contentDescription = "image Show",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp), text = "lokasi: ${data.lokasi ?: "N/A"}", fontSize = 18.sp
            )
        }
    }
}


// Preview the UI
@Preview
@Composable
fun PreviewDataItemView() {
    DataItemView(
        PromoModels(
            id = 1,
            Title = "Sample Title",
            publishedAt = "2023-07-23",
            created_at = "2023-07-22",
            updatedAt = "2023-07-23",
            namePromo = "Sample Promo",
            descPromo = "This is a sample promo",
            nama = "Sample Name",
            desc = "Sample Description",
            latitude = "0.0",
            longitude = "0.0",
            alt = "0",
            createdAt = "2023-07-20",
            lokasi = "Sample Location",
            count = 10,
            img = Img()
        )// Replace with the actual Img object or provide null if no image
    )
}