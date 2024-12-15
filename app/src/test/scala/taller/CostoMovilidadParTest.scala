package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CostoMovilidadParTest extends AnyFunSuite {
    test("costoMovilidadPar calcula correctamente el costo de movilidad en paralelo") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        val progRiego = Vector(0, 1)
        val distancia = Vector(
            Vector(0, 5),
            Vector(5, 0)
        )
        assert(App.costoMovilidadPar(finca, progRiego, distancia) == App.costoMovilidad(finca, progRiego, distancia))
    }

    test("costoMovilidadPar devuelve 0 para una programación vacía") {
        val finca = Vector()
        val progRiego = Vector()
        val distancia = Vector()
        assert(App.costoMovilidadPar(finca, progRiego, distancia) == 0)
    }

    test("costoMovilidadPar maneja correctamente distancias grandes entre tablones") {
        val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
        val progRiego = Vector(0, 2, 1)
        val distancia = Vector(
            Vector(0, 100, 200),
            Vector(100, 0, 150),
            Vector(200, 150, 0)
        )
        assert(App.costoMovilidadPar(finca, progRiego, distancia) == 350)
    }

    test("costoMovilidadPar calcula correctamente para una programación con un solo tablón") {
        val finca = Vector((10, 3, 2))
        val progRiego = Vector(0)
        val distancia = Vector(Vector(0))
        assert(App.costoMovilidadPar(finca, progRiego, distancia) == 0)
    }

    test("Costo de movilidad paralelo con finca y distancias muy altas entre tablones") {
    val finca4 = Vector((100, 5, 1), (150, 4, 2))
    val distancia4 = Vector(Vector(0, 200), Vector(200, 0))
    val prog4 = Vector(1, 0)
    val resultado = App.costoMovilidadPar(finca4, prog4, distancia4)
    
    // Cálculo de la distancia entre tablones
    assert(resultado == 200)
  }
}