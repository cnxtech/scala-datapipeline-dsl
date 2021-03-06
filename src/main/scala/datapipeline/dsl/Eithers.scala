/*
 * Copyright 2018 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License
 */

package datapipeline.dsl

import org.json4s.JsonDSL._
import org.json4s._

sealed trait CommandOrScriptUri {
  val json: JObject
}

case class Command(command: String, arguments: Seq[String] = Nil) extends CommandOrScriptUri {
  override val json: JObject = ("command" -> command) ~ ("scriptArgument" -> arguments)
}

case class ScriptUri(scriptUri: String) extends CommandOrScriptUri {
  override val json: JObject = "scriptUri" -> scriptUri
}