package ai.trueface.sdk.models

object Errors {
    val e400: String = "Bad Request – Your request sucks"
    val e401: String = "Unauthorized – Your API key is wrong"
    val e403: String = "Forbidden – The kitten requested is hidden for administrators only"
    val e404: String = "Not Found – The specified kitten could not be found"
    val e405: String = "Method Not Allowed – You tried to access a kitten with an invalid method"
    val e406: String = "Not Acceptable – You requested a format that isn’t json"
    val e410: String = "Gone – The kitten requested has been removed from our servers"
    val e418: String = "I’m a teapot"
    val e429: String = "Too Many Requests – You’re requesting too many kittens! Slow down!"
    val e500: String = "Internal Server Error – We had a problem with our server. Try again later."
    val e503: String = "Service Unavailable – We’re temporarily offline for maintenance. Please try again later."
}
