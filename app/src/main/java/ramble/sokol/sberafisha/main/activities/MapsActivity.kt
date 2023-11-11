package ramble.sokol.sberafisha.main.activities

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import ramble.sokol.sberafisha.R

class MapsActivity : ComponentActivity(){

    private lateinit var mapView: MapView
    private lateinit var imageBack: ImageButton

    // single activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("a527d12d-2fd5-4eaf-9b11-4a301efad482")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapview)
        val map = mapView.mapWindow.map
        map.move(
            CameraPosition(
                Point(54.782635, 32.045287),
                /* zoom = */ 13.0f,
                /* azimuth = */ 150.0f,
                /* tilt = */ 0.0f
            )
        )
        init()

        val mapObjectTapListener = MapObjectTapListener { mapObject: MapObject, _ ->
            true
        }



    }


    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    private fun init(){
        imageBack = findViewById(R.id.icon_back_actually_map)
        imageBack.setOnClickListener {
            onBackPressed()
        }
    }

}
