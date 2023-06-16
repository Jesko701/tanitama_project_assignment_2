//import com.example.tanitama.ui.screen.signup.SignUp
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tanitama.CameraActivity
import com.example.tanitama.WeatherState
import com.example.tanitama.WeatherViewModel

//class TanitamaApp(function: () -> Unit) : Application() {
//    override fun onCreate() {
//        super.onCreate()
//    }
//}

@Composable
fun TanitamaApp() {

}
//    val signUpViewModel: SignUpViewModel = viewModel()
//    val signInViewModel: SignInViewModel = viewModel()
//    val homeViewModel: WeatherViewModel = viewModel()
//    val navController = rememberNavController()
////
//    NavHost(navController, startDestination = "home") {
////        composable("signup") {
////            Screen.SignUp(signUpViewModel = signUpViewModel, navController = navController)
////        }
//////        composable("signin") {
//////            Screen.SignIn(
//////                signInViewModel = signInViewModel,
//////                navController = navController,
//////                state = LoginState()
//////            )
//////        }
////        composable("home") {
////            Home(homeViewModel = WeatherViewModel, navController = navController, state = WeatherState())
////        }
//////        composable("prediksi") {
//////            Prediksi(navController)
//////        }
////        composable("deteksi") {
////            Deteksi(navController)
////        }
////        composable("pasar") {
////            Pasar(navController)
////        }
////    }
//    }
//}