package com.ngga_ring.aplikasimobileapppromo.data.extensi

import com.google.gson.Gson


fun Any.toJson(): String = Gson().toJson(this)

