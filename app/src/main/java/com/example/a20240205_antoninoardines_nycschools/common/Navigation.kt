package com.example.a20240205_antoninoardines_nycschools.common

object Navigation {
    const val SCHOOL_HOME_NAV = "school_list"
    const val SCHOOL_DETAIL_NAV = "school_detail"
    const val SCHOOL_DETAIL_ARG = "school_dbn"
    const val SCHOOL_DETAIL_PATH = "$SCHOOL_DETAIL_NAV/{$SCHOOL_DETAIL_ARG}"
}