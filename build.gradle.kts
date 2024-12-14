import io.codetoil.mcgradlelauncher.LaunchMCTask
import org.multimc.ParamBucket
import java.net.URI

plugins {
    java
    id("io.codetoil.mcgradlelauncher") version("0.1.0")
}

group = "io.codetoil"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = URI.create("https://files.minecraftforge.net") }
    maven { url = URI.create("https://hub.spigotmc.org/nexus/content/groups/public/") }
    maven { url = URI.create("https://maven.fabricmc.net/") }
    maven { url = URI.create("https://libraries.minecraft.net/") }
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(files("./lib/minecraft-1.7.10.jar"))
    implementation("net.minecraft:launchwrapper:1.12")
    implementation("com.google.code.findbugs:jsr305:1.3.9")
    implementation("org.ow2.asm:asm-debug-all:5.0.3")
    implementation("com.typesafe.akka:akka-actor_2.11:2.3.3")
    implementation("com.typesafe:config:1.2.1")
    implementation("org.scala-lang:scala-actors-migration_2.11:1.1.0")
    implementation("org.scala-lang:scala-compiler:2.11.1")
    implementation("org.scala-lang.plugins:scala-continuations-library_2.11:1.0.2")
    implementation("org.scala-lang.plugins:scala-continuations-plugin_2.11.1:1.0.2")
    implementation("org.scala-lang:scala-library:2.11.1")
    implementation("org.scala-lang.modules:scala-parser-combinators_2.11:1.0.1")
    implementation("org.scala-lang:scala-reflect:2.11.1")
    implementation("org.scala-lang.modules:scala-swing_2.11:1.0.1")
    implementation("org.scala-lang.modules:scala-xml_2.11:1.0.2")
    implementation("net.sf.jopt-simple:jopt-simple:4.5")
    implementation("lzma:lzma:0.0.1")
    implementation("com.mojang:realms:1.3.5")
    implementation("org.apache.commons:commons-compress:1.8.1")
    implementation("org.apache.httpcomponents:httpclient:4.3.3")
    implementation("commons-logging:commons-logging:1.1.3")
    implementation("org.apache.httpcomponents:httpcore:4.3.2")
    implementation("java3d:vecmath:1.3.1")
    implementation("net.sf.trove4j:trove4j:3.0.3")
    implementation("com.ibm.icu:icu4j-core-mojang:51.2")
    implementation("com.paulscode:codecjorbis:20101023")
    implementation("com.paulscode:codecwav:20101023")
    implementation("com.paulscode:libraryjavasound:20101123")
    implementation("com.paulscode:librarylwjglopenal:20100824")
    implementation("com.paulscode:soundsystem:20120107")
    implementation("io.netty:netty-all:4.0.10.Final")
    implementation("com.google.guava:guava:17.0")
    implementation("org.apache.commons:commons-lang3:3.3.2")
    implementation("commons-io:commons-io:2.4")
    implementation("commons-codec:commons-codec:1.9")
    implementation("net.java.jinput:jinput:2.0.5")
    implementation("net.java.jutils:jutils:1.0.0")
    implementation("com.google.code.gson:gson:2.2.4")
    implementation("com.mojang:authlib:1.5.16")
    implementation("org.apache.logging.log4j:log4j-api:2.0-beta9")
    implementation("org.apache.logging.log4j:log4j-core:2.0-beta9")
    implementation("org.lwjgl.lwjgl:lwjgl:2.9.1")
    implementation("org.lwjgl.lwjgl:lwjgl_util:2.9.1")
    implementation("org.lwjgl.lwjgl:lwjgl-platform:2.9.1")
    implementation("net.java.jinput:jinput-platform:2.0.5")
    implementation("tv.twitch:twitch:5.16")
}

val bucket: ParamBucket = ParamBucket()

bucket.add("param", "--version")
bucket.add("param", "1.7.10-mcgradlelauncher")
bucket.add("param", "--accessToken")
bucket.add("param", "0")
bucket.add("param", "--assetsDir")
bucket.add("param", "assets")
bucket.add("param", "--assetsIndex")
bucket.add("param", "1.7.10")
bucket.add("param", "--userProperties")
bucket.add("param", "{}")
bucket.add("mainClass", "net.minecraft.client.main.Main")

project.tasks.register("launchMC", LaunchMCTask::class.java)
{
    group = "mcgradlelaunchertest"
    description = "Launches Minecraft"
    acceptableOutput.set(0)
    params.set(bucket)
}