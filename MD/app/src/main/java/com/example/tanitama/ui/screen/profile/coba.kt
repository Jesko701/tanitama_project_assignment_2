package com.example.tanitama.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tanitama.R
import com.example.tanitama.data.response.ApiService
import com.example.tanitama.ui.screen.prediksi.WeeklyPricePredictionViewModel

@Composable
fun PricePredictionScreen() {
    var selectedButton by remember { mutableStateOf(PricePeriod.Weekly) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "SARAN/PREDIKSI")
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,

            ) {
            Button(
                onClick = { selectedButton = PricePeriod.Weekly },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton == PricePeriod.Weekly) Color(0XFF59BE49) else Color(
                        0XFF6A6A6A
                    )
                )
            ) {
                Text(text = "1 Minggu")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { selectedButton = PricePeriod.Monthly },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton == PricePeriod.Monthly) Color(0XFF59BE49) else Color(
                        0XFF6A6A6A
                    )
                )
            ) {
                Text(text = "1 Bulan")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { selectedButton = PricePeriod.Yearly },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton == PricePeriod.Yearly) Color(0XFF59BE49) else Color(
                        0XFF6A6A6A
                    )
                )
            ) {
                Text(text = "3 Bulan")
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        when (selectedButton) {
            PricePeriod.Weekly -> {
                // Tampilkan prediksi harga mingguan di sini
                Text(text = "Prediksi Harga Mingguan")
            }

            PricePeriod.Monthly -> {
                // Tampilkan prediksi harga bulanan di sini
                Text(text = "Prediksi Harga Bulanan")
            }

            PricePeriod.Yearly -> {
                // Tampilkan prediksi harga tahunan di sini
                Text(text = "Prediksi Harga Tahunan")
            }
        }
    }
}

enum class PricePeriod {
    Weekly,
    Monthly,
    Yearly
}

@Composable
fun CardMingguan(
    modifier: Modifier = Modifier,
    viewModel: WeeklyPricePredictionViewModel
) {
    val pricePrediction = viewModel.pricePrediction!!
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Box(modifier = Modifier.height(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.bawang_merah),
                    contentDescription = "Prediksi Harga Bawang Merah",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Bawang Merah",
                    style = TextStyle(color = Color.White, fontSize = 29.sp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Rp. ${pricePrediction.bawangMerah[1]}",
                        style = TextStyle(color = Color.White, fontSize = 44.sp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(Color(0XFFEDA335))
                        ) {
                            Row(
                                modifier = Modifier.padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = null
                                )
                                Text(
                                    "Rp. ${pricePrediction.bawangMerah[0]}",
                                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                                )
                            }
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(Color(0XFF0EB6DB))
                        ) {
                            Row(
                                modifier = Modifier.padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.up),
                                    contentDescription = null
                                )
                                Text(
                                    "Rp. ${pricePrediction.bawangMerah[2]}",
                                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                                )
                            }
                        }
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Box(modifier = Modifier.height(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.bawang_putih),
                        contentDescription = "Prediksi Harga Bawang Putih",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Bawang Putih",
                        style = TextStyle(color = Color.White, fontSize = 29.sp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Rp. ${pricePrediction.bawangPutih[1]}",
                            style = TextStyle(color = Color.White, fontSize = 44.sp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 12.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFFEDA335))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.down),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.bawangPutih[0]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFF0EB6DB))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.bawangPutih[2]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Box(modifier = Modifier.height(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.beras),
                        contentDescription = "Prediksi Harga Beras",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Beras",
                        style = TextStyle(color = Color.White, fontSize = 29.sp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Rp. ${pricePrediction.beras[1]}",
                            style = TextStyle(color = Color.White, fontSize = 44.sp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 12.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFFEDA335))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.down),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.beras[0]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFF0EB6DB))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.beras[2]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Box(modifier = Modifier.height(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.cabai_merah),
                        contentDescription = "Prediksi Harga Cabai Merah",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Cabai Merah",
                        style = TextStyle(color = Color.White, fontSize = 29.sp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Rp. ${pricePrediction.cabaiMerah[1]}",
                            style = TextStyle(color = Color.White, fontSize = 44.sp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 12.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFFEDA335))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.down),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.cabaiMerah[0]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0XFF0EB6DB))
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null
                                    )
                                    Text(
                                        "Rp. ${pricePrediction.cabaiMerah[2]}",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//    @Preview(showBackground = true)
//    @Composable
//    fun cobaPreview() {
//        val apiService = ApiService()
//        val viewModel = WeeklyPricePredictionViewModel(apiService)
//        CardMingguan(viewModel = viewModel)
//    }