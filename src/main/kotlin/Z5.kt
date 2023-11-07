
import java.text.DecimalFormat
import kotlin.math.sqrt

data class Point(val x: Double, val y: Double)
class Triangle(val A: Point, val B: Point, val C: Point) {
    fun getcen(): Point {
        val lAB = A.distanceTo(B)
        val lBC = B.distanceTo(C)
        val lAC = A.distanceTo(C)

        val l_all = lAB + lBC + lAC

        val cen_X = (lAB * C.x + lBC * A.x + lAC * B.x) / l_all
        val cen_Y = (lAB * C.y + lBC * A.y + lAC * B.y) / l_all

        val p = (lAB + lBC + lAC)/2
        val r = (sqrt((p - lAB)*(p - lBC)*(p - lAC)/p))
        println("Радиус вписанной окружности: " + r)
        return Point(cen_X, cen_Y)
    }
}

fun Point.distanceTo(other: Point): Double {
    val dx = x - other.x
    val dy = y - other.y
    return sqrt(dx * dx + dy * dy)
}

fun main() {
    val df = DecimalFormat("#.###")
    val A = Point(1.0, 3.0)
    val B = Point(4.0, 0.0)
    val C = Point(2.0, 7.0)

    val triangle = Triangle(A, B, C)
    val cen = triangle.getcen()

    println("Центр вписанной окружности: (${df.format(cen.x)} : ${df.format(cen.y)})")

}