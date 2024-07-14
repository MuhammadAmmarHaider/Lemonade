package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp()
{
    LemonTreePage()
//    LemonPage()
//    LemonJuicePage()
//    EmptyGlassPage()
}
@Composable
fun LemonTreePage(modifier:Modifier=Modifier)
{
//    var result by remember { mutableStateOf(1) }
    var result by remember { mutableStateOf(1) }
    var tapCount by remember { mutableStateOf(0) }
    val text= stringResource(id = R.string.lemon_tree)
    val desc:String
    val imageId:Int
    when(result)
    {
        1->{desc= stringResosurce(id = R.string.lemon_tree_desc)
            imageId=R.drawable.lemon_tree

        }
        2->{
            desc= stringResource(id = R.string.lemon_desc)
            imageId=R.drawable.lemon_squeeze
            tapCount=(2..4).random()
        }
        3->{
            desc= stringResource(id = R.string.lemon_glass_desc)
            imageId=R.drawable.lemon_drink
        }
        else->
        {
            desc= stringResource(id = R.string.empty_glass_desc)
            imageId=R.drawable.lemon_restart
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        Text(text = text,modifier= modifier
            .background(Color(0xFFFFFF00))
            .padding(36.dp)
            .fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 32.sp )
        Spacer(modifier = modifier.height(240.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                tapCount--
                if(tapCount<=0)
                {
                    if((result+1)==5)
                        {result=1}
                    else result++
                }
            }) {
                Image(painter = painterResource(id =imageId ), contentDescription =desc )
            }

            Text(text=desc,modifier=modifier.padding(top=16.dp))
        }


    }
}
@Composable
fun LemonPage(modifier: Modifier=Modifier)
{
    val text= stringResource(id = R.string.app_name)
    val desc= stringResource(id = R.string.lemon_desc)
    val image= painterResource(id = R.drawable.lemon_squeeze)
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier=modifier.fillMaxSize()) {
        Text(text=text,modifier= modifier
            .background(Color(0xFFFFFF00))
            .padding(36.dp)
            .fillMaxWidth(), fontWeight = FontWeight.Bold,fontSize=32.sp, textAlign = TextAlign.Center)
        Spacer(modifier = modifier.height(240.dp))
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = { /*TODO*/ }) {
                Image(painter = image, contentDescription ="lemon" )
            }
            Text(text=desc,modifier=modifier.padding(top=16.dp))
        }
    }
}
@Composable
fun LemonJuicePage(modifier: Modifier=Modifier)
{
    val text= stringResource(id = R.string.app_name)
    val image= painterResource(id = R.drawable.lemon_drink)
    val desc= stringResource(id = R.string.lemon_glass_desc)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        Text(text = text,modifier= modifier
            .background(Color(0xFFFFFF00))
            .padding(36.dp)
            .fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 32.sp, textAlign = TextAlign.Center)
        Spacer(modifier =modifier.height(240.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ }) {
                Image(painter = image, contentDescription ="Lemon juice" )
            }
            Text(text =desc,modifier=modifier.padding(16.dp))
        }
    }
}

@Composable
fun EmptyGlassPage(modifier: Modifier=Modifier)
{
    val text= stringResource(id = R.string.app_name)
    val image= painterResource(id = R.drawable.lemon_restart)
    val desc= stringResource(id = R.string.empty_glass_desc)
    Column(modifier=modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text,
            modifier
                .background(Color(0xFFFFFF00))
                .padding(36.dp)
                .fillMaxWidth(), fontSize = 32.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(modifier = modifier.height(240.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ } ){
                Image(painter = image, contentDescription =desc)
            }
            Text(text=desc,modifier=modifier.padding(16.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}