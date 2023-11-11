package ramble.sokol.sberafisha.actually.view.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.sberafisha.R
import ramble.sokol.sberafisha.authentication_and_splash.view.components.ButtonForEntryToRegistration
import ramble.sokol.sberafisha.main.activities.MapsActivity
import ramble.sokol.sberafisha.ui.theme.ColorTextHint
import ramble.sokol.sberafisha.ui.theme.TextTitle

@Composable
@Destination
fun ActuallyScreen(
    navigator: DestinationsNavigator
){
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp, start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.image_after_test),
            contentDescription = "",
            contentScale = ContentScale.Crop)
        
        Spacer(modifier = Modifier.padding(top = 16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_map_dost),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.mont_bold)),
                fontWeight = FontWeight(800),
                color = TextTitle,
                letterSpacing = 0.24.sp,
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_map_dost_desc),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.5.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                fontWeight = FontWeight(700),
                color = ColorTextHint,
                textAlign = TextAlign.Center,
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        ButtonForEntryToRegistration(text = stringResource(id = R.string.text_to_map)) {
            context.startActivity(Intent(context, MapsActivity::class.java))
        }

    }

}