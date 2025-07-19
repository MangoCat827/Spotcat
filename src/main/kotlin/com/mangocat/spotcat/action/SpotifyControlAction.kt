package com.mangocat.spotcat.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.mangocat.spotcat.action.SpotifyCommand.*
import com.mangocat.spotcat.spotify.SpotifyMacService

open class SpotifyControlAction(
    private val command: SpotifyCommand,
    text: String,
    description: String
) : AnAction(text, description, null) {

    private val spotifyService = SpotifyMacService()

    override fun actionPerformed(e: AnActionEvent) {
        when (command) {
            PLAY_PAUSE -> spotifyService.playPause()
            NEXT_TRACK -> spotifyService.nextTrack()
            PREVIOUS_TRACK -> spotifyService.previousTrack()
        }
    }
}

class SpotifyPlayActionDelegate :
    SpotifyControlAction(PLAY_PAUSE, "Spotify: Play/Pause", "Toggle playback in Spotify")

class SpotifyNextActionDelegate :
    SpotifyControlAction(NEXT_TRACK, "Spotify: Next Track", "Skip to next track")

class SpotifyPreviousActionDelegate :
    SpotifyControlAction(PREVIOUS_TRACK, "Spotify: Previous Track", "Go to previous track")

