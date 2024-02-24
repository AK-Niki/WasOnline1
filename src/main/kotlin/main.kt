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
        minutes % 10 == 1 && minutes != 11 -> "$minutes минуту"
        (minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4) && !(minutes >= 12 && minutes <= 14) -> "$minutes минуты"
        else -> "$minutes минут"
    } + " назад"
}

fun formatHoursAgo(hours: Int): String {
    return when {
        hours == 1 || hours == 21 -> "$hours час назад"
        (hours >= 2 && hours <= 4) || (hours >= 22 && hours <= 24) -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}
