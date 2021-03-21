package ly.project.reminder

const val LOCATION_PERMISSION_REQUEST_CODE = 23
const val ATHAN_RINGTONE_REQUEST_CODE = 19
const val CALENDAR_READ_PERMISSION_REQUEST_CODE = 55
const val CALENDAR_EVENT_ADD_MODIFY_REQUEST_CODE = 63

const val LANG_FA = "fa"
const val LANG_FA_AF = "fa-AF"
const val LANG_PS = "ps"
const val LANG_GLK = "glk"
const val LANG_AR = "ar"
const val LANG_EN_IR = "en"
const val LANG_EN_US = "en-US"
const val LANG_JA = "ja"
const val LANG_AZB = "azb"
const val LANG_CKB = "ckb"
const val LANG_UR = "ur"

const val LAST_CHOSEN_TAB_KEY = "LastChosenTab"

const val PREF_MAIN_CALENDAR_KEY = "mainCalendarType"
const val PREF_OTHER_CALENDARS_KEY = "otherCalendarTypes"
const val PREF_KEY_ATHAN = "Athan"
const val PREF_PRAY_TIME_METHOD = "SelectedPrayTimeMethod"
const val PREF_ISLAMIC_OFFSET = "islamic_offset"
const val PREF_LATITUDE = "Latitude"
const val PREF_LONGITUDE = "Longitude"
const val PREF_SELECTED_LOCATION = "Location"
const val PREF_GEOCODED_CITYNAME = "cityname"
const val PREF_ALTITUDE = "Altitude"
const val PREF_WIDGET_IN_24 = "WidgetIn24"
const val PREF_IRAN_TIME = "IranTime"
const val PREF_PERSIAN_DIGITS = "PersianDigits"
const val PREF_ATHAN_URI = "AthanURI"
const val PREF_ATHAN_NAME = "AthanName"
const val PREF_SHOW_DEVICE_CALENDAR_EVENTS = "showDeviceCalendarEvents"
const val PREF_WIDGET_CLOCK = "WidgetClock"
const val PREF_NOTIFY_DATE = "NotifyDate"
const val PREF_NOTIFICATION_ATHAN = "NotificationAthan"
const val PREF_NOTIFY_DATE_LOCK_SCREEN = "NotifyDateLockScreen"
const val PREF_ATHAN_VOLUME = "AthanVolume"
const val PREF_ASCENDING_ATHAN_VOLUME = "AscendingAthanVolume"
const val PREF_APP_LANGUAGE = "AppLanguage"
const val PREF_SELECTED_WIDGET_TEXT_COLOR = "SelectedWidgetTextColor"
const val PREF_SELECTED_WIDGET_BACKGROUND_COLOR = "SelectedWidgetBackgroundColor"
const val PREF_SELECTED_DATE_AGE_WIDGET = "SelectedDateForAgeWidget"
const val PREF_TITLE_AGE_WIDGET = "TitleForAgeWidget"
const val PREF_ATHAN_ALARM = "AthanAlarm"
const val PREF_ATHAN_GAP = "AthanGap"
const val PREF_THEME = "Theme"
const val PREF_HOLIDAY_TYPES = "holiday_types"
const val PREF_WEEK_START = "WeekStart"
const val PREF_WEEK_ENDS = "WeekEnds"
const val PREF_SHIFT_WORK_STARTING_JDN = "ShiftWorkJdn"
const val PREF_SHIFT_WORK_SETTING = "ShiftWorkSetting"
const val PREF_SHIFT_WORK_RECURS = "ShiftWorkRecurs"

const val CHANGE_LANGUAGE_IS_PROMOTED_ONCE = "CHANGE_LANGUAGE_IS_PROMOTED_ONCE"

const val DEFAULT_CITY = "CUSTOM"
const val DEFAULT_PRAY_TIME_METHOD = "Tehran"
const val DEFAULT_APP_LANGUAGE = "fa"
const val DEFAULT_SELECTED_WIDGET_TEXT_COLOR = "#ffffffff"
const val DEFAULT_SELECTED_WIDGET_BACKGROUND_COLOR = "#00000000"
const val DEFAULT_WIDGET_IN_24 = true
const val DEFAULT_IRAN_TIME = false
const val DEFAULT_PERSIAN_DIGITS = true
const val DEFAULT_WIDGET_CLOCK = true
const val DEFAULT_NOTIFY_DATE = true
const val DEFAULT_NOTIFICATION_ATHAN = false
const val DEFAULT_NOTIFY_DATE_LOCK_SCREEN = true
const val DEFAULT_ATHAN_VOLUME = 1
const val DEFAULT_WEEK_START = "0"

// WeekEnds, 6 means Friday
val DEFAULT_WEEK_ENDS: Set<String> = setOf("6")

const val LIGHT_THEME = "LightTheme"
const val DARK_THEME = "DarkTheme"

const val LOAD_APP_ID = 1000
const val THREE_HOURS_APP_ID = 1010
const val ALARMS_BASE_ID = 2000

const val OFFSET_ARGUMENT = "OFFSET_ARGUMENT"
const val BROADCAST_ALARM = "BROADCAST_ALARM"
const val BROADCAST_RESTART_APP = "BROADCAST_RESTART_APP"
const val BROADCAST_UPDATE_APP = "BROADCAST_UPDATE_APP"
const val KEY_EXTRA_PRAYER_KEY = "prayer_name"
const val FONT_PATH = "fonts/NotoNaskhArabic-Regular.ttf"

const val RLM = '\u200F'
const val ZWJ = "\u200D"

const val DEFAULT_AM = "ق.ظ"
const val DEFAULT_PM = "ب.ظ"

val PERSIAN_DIGITS = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
val DAYS_ICONS_PERSIAN = listOf(
    0,
    R.mipmap.day1, R.mipmap.day2, R.mipmap.day3, R.mipmap.day4, R.mipmap.day5,
    R.mipmap.day6, R.mipmap.day7, R.mipmap.day8, R.mipmap.day9, R.mipmap.day10,
    R.mipmap.day11, R.mipmap.day12, R.mipmap.day13, R.mipmap.day14, R.mipmap.day15,
    R.mipmap.day16, R.mipmap.day17, R.mipmap.day18, R.mipmap.day19, R.mipmap.day20,
    R.mipmap.day21, R.mipmap.day22, R.mipmap.day23, R.mipmap.day24, R.mipmap.day25,
    R.mipmap.day26, R.mipmap.day27, R.mipmap.day28, R.mipmap.day29, R.mipmap.day30,
    R.mipmap.day31
)


