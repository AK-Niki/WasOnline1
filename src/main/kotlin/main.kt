fun main() {
    agoToText(3601)
}

fun agoToText(secondsAgo: Int) {
    val minutes = secondsAgo / 60
    val hours = secondsAgo / 3600

    val result = when {
        secondsAgo >= 0 && secondsAgo <= 60 -> "был(а) только что"
        secondsAgo > 60 && secondsAgo <= (60 * 60) -> "был(а) ${formatMinutesAgo(minutes)} назад"
        secondsAgo > (60 * 60) && secondsAgo <= (24 * 60 * 60) -> "был(а) ${formatHoursAgo(hours)} назад"
        secondsAgo > (24 * 60 * 60) && secondsAgo <= (2 * 24 * 60 * 60) -> "был(а) вчера"
        secondsAgo > (2 * 24 * 60 * 60) && secondsAgo <= (3 * 24 * 60 * 60) -> "был(а) позавчера"
        else -> "был(а) давно"
    }

    println(result)
}

fun formatMinutesAgo(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "$minutes минуту"
        minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "$minutes минуты"
        else -> "$minutes минут"
    } + " назад"
}

fun formatHoursAgo(hours: Int): String {
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "$hours час"
        hours % 10 in 2..4 && hours % 100 !in 12..14 -> "$hours часа"
        else -> "$hours часов"
    } + " назад"
}