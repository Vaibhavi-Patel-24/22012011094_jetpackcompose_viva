package com.example.a22012011094_jetpackcompose_viva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a22012011094_jetpackcompose_viva.ui.theme._22012011094_jetpackcompose_vivaTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _22012011094_jetpackcompose_vivaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Replace Greeting with EventDetailScreen
                    EventDetailScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventDetailScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Leave space for the static buttons
                .verticalScroll(rememberScrollState()) // Makes the content scrollable
        ) {
            // Event Image
            Image(
                painter = painterResource(id = R.drawable.event), // Replace with your event image
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Event Title and Location
            Text(
                text = "Tech Conference 2024",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Mehsana, Gujarat | 2.5 km away",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This is a detailed description of the event...",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Event Schedule Section
            Text(
                text = "Event Schedule",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
            LazyRow(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                items(3) { index ->
                    EventScheduleCard(
                        time = if (index == 0) "10:00 AM" else "11:30 AM",
                        title = if (index == 0) "Keynote Speech" else "Networking Session"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reviews Section
            Text(
                text = "Reviews",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

// Reviews
            ReviewCard(
                name = "Alice Johnson",
                review = "Great event! Well-organized and informative.",
                rating = 5
            )
            ReviewCard(
                name = "Bob Smith",
                review = "Really enjoyed the keynote speaker. Would recommend!",
                rating = 4
            )
            ReviewCard(
                name = "Charlie Davis",
                review = "Good event overall, but some sessions were too short.",
                rating = 3
            )

        }

        // Static Buttons at the Bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Aligns the Row at the bottom of the Box
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Handle Buy Tickets */ }) {
                Text(text = "Buy Tickets", fontSize = 16.sp) // Increased font size
            }
            Button(onClick = { /* Handle Add to Calendar */ }) {
                Text(text = "Add to Calendar", fontSize = 16.sp) // Increased font size
            }
        }
    }
}

@Composable
fun EventScheduleCard(time: String, title: String) {
    Card(
        shape = RoundedCornerShape(12.dp), // Slightly rounded edges
        modifier = Modifier.size(160.dp, 100.dp) // Increased size
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(12.dp) // Added padding inside the card
        ) {
            Text(text = time, fontWeight = FontWeight.Bold, fontSize = 16.sp) // Larger text
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, textAlign = TextAlign.Center, fontSize = 14.sp) // Larger text
        }
    }
}

@Composable
fun ReviewCard(name: String, review: String, rating: Int) {
    Card(
        shape = RoundedCornerShape(12.dp), // Slightly rounded edges
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp) // Increased vertical padding
    ) {
        Row(
            modifier = Modifier.padding(12.dp), // Increased padding inside the card
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person, // Use a Material Design icon
                contentDescription = "Avatar",
                modifier = Modifier.size(50.dp), // Icon size
                tint = Color.Gray // Optional: Add tint to the icon
            )
            Spacer(modifier = Modifier.width(12.dp)) // Increased spacing
            Column {
                Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp) // Larger text
                Text(text = review, fontSize = 14.sp, color = Color.Gray) // Larger text
                Row {
                    repeat(rating) {
                        Icon(
                            painter = painterResource(id = R.drawable.star), // Replace with star icon
                            contentDescription = "Star",
                            modifier = Modifier.size(18.dp), // Increased star size
                            tint = Color.Yellow
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailPreview() {
    _22012011094_jetpackcompose_vivaTheme {
        EventDetailScreen()
    }
}