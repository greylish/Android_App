package com.jayson.jetpackcompose_two

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jayson.jetpackcompose_two.ui.theme.JetpackCompose_TwoTheme

class TopAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_TwoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApp(){
    val context = LocalContext.current.applicationContext
TopAppBar(
    title = { Text(text = "iPhone")},
    navigationIcon = {
        IconButton(onClick = {Toast.makeText(context,"You have clicked the home icon",Toast.LENGTH_SHORT).show()}) {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
        }
    },
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Red,
        titleContentColor = Color.White,
        navigationIconContentColor = Color.White
    ),
    actions = {
        IconButton(onClick = {Toast.makeText(context,"You have clicked on a search icon",Toast.LENGTH_SHORT).show()}) {
           Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
        }
        IconButton(onClick = {Toast.makeText(context,"You have clicked the share icon",Toast.LENGTH_SHORT).show()}) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = "Share", tint = Color.White)
        }
        IconButton(onClick = {Toast.makeText(context,"You have clicked the menu icon",Toast.LENGTH_SHORT).show()}) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "Person", tint = Color.White)
        }
    })
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopAppPreview(){
    TopApp()
}
