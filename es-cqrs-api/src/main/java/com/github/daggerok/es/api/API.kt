package com.github.daggerok.es.api

import java.util.*

interface Identifiable {
  fun identifier(): UUID
}

interface Command : Identifiable
