package com.example.registrovacina_front

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registrovacina_front.ui.theme.RegistroVacinafrontTheme
import com.example.registrovacina_frontend.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroVacinafrontTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        content = { innerPadding ->
            ContentArea(modifier = Modifier.padding(innerPadding))
        }
    )
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF007AFF)) // Blue background
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_vaccine),
                contentDescription = "Vaccine Icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Vacinação",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ContentArea(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MenuItem(iconRes = R.drawable.ic_calendar, label = "Calendário")
            MenuItem(iconRes = R.drawable.ic_history, label = "Histórico")
        }
        // Additional placeholders for other items
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.size(80.dp).background(Color.LightGray, shape = CircleShape))
            Box(modifier = Modifier.size(80.dp).background(Color.LightGray, shape = CircleShape))
        }
    }
}

@Composable
fun MenuItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFEEF5FF), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                tint = Color(0xFF007AFF)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, fontSize = 14.sp)
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFF007AFF)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home), // Replace with actual drawable resource
                contentDescription = "Home",
                tint = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_calendar), // Replace with actual drawable resource
                contentDescription = "Calendar",
                tint = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_plus), // Replace with actual drawable resource
                contentDescription = "Add",
                tint = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_profile), // Replace with actual drawable resource
                contentDescription = "Profile",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RegistroVacinafrontTheme {
        HomeScreen()
    }
}
