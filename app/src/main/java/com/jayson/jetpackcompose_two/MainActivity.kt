package com.jayson.jetpackcompose_two

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayson.jetpackcompose_two.ui.theme.JetpackCompose_TwoTheme
import com.jayson.jetpackcompose_two.ui.theme.LazyColumnActivity
import java.text.BreakIterator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_TwoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(20.dp)
                        ) {
                            ImageCard(
                                painter = painterResource(id = R.drawable.card),
                                contentDescription = "mycard", title = "this is my nature"
                            )
                            Button(onClick = {
                                val intent = Intent(
                                    this@MainActivity,
                                    ScrollActivity::class.java
                                )
                                startActivity(intent)
                            }) {
                                Text(text = "SCROLLABLE")
                            }
                            Button(onClick = {
                                val intent = Intent(
                                    this@MainActivity,
                                    TopAppActivity::class.java
                                )
                                startActivity(intent)
                            }) {
                                Text(text = "TOPAPPACTIVITY")
                            }
                            Button(onClick = {
                                val intent = Intent(
                                    this@MainActivity,
                                    LazyColumnActivity::class.java
                                )
                                startActivity(intent)
                            }) {
                                Text(text = "LazyColumn")
                            }
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(painter: Painter, contentDescription:String,title:String){
    Column {
        Card (
            modifier = Modifier.wrapContentWidth(),
            elevation = CardDefaults.cardElevation(20.dp),
            shape = RoundedCornerShape(15.dp)
        ){
            Box (
                modifier = Modifier.height(200.dp)
            ){
                Image(painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop)
                Box (
                    modifier = Modifier
                        .matchParentSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart
                ){
                    Text(text = title,
                        color = Color.DarkGray,
                        fontWeight = FontWeight(50),
                        fontFamily = FontFamily.Cursive
                    )
                }
            }
        }

    }

}
@Preview
@Composable
fun ImageCardPreview(){
    ImageCard(painter = painterResource(id = R.drawable.card),
        contentDescription = "mycard",title ="this is a nature")
}