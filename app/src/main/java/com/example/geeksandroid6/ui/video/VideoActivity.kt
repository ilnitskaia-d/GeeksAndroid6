package com.example.geeksandroid6.ui.video

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.example.geeksandroid6.R
import com.example.geeksandroid6.databinding.ActivityVideoBinding
import com.example.geeksandroid6.utils.Constants
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoActivity : AppCompatActivity() {
    private var player: SimpleExoPlayer? = null
    private lateinit var binding: ActivityVideoBinding

    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L
    private lateinit var videoUrl:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        videoUrl = Constants.BASE_VIDEO_URL + "N6pnoVEtLwQ"

        initPlayer()

    }

    @SuppressLint("StaticFieldLeak")
    private fun initPlayer(){
        player = SimpleExoPlayer.Builder(this).build()
        binding.playerView.player = player

        object : YouTubeExtractor(this) {
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if(ytFiles != null) {
                    val videoItag = 133
                    val audioItag = 140
                    val videoUrl = ytFiles[videoItag].url
                    val audioUrl = ytFiles[audioItag].url

                    val audioSource = ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(audioUrl))

                    val videoSource = ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(videoUrl))

                    player?.apply {
                        setMediaSource(
                            MergingMediaSource(
                                true,
                                videoSource,
                                audioSource
                            ),
                            true
                        )

                        prepare()
                        playWhenReady = this@VideoActivity.playWhenReady
                        seekTo(mediaItemIndex, playbackPosition)
                    }
                }
            }
        }.extract(videoUrl, false, false)
    }

    override fun onStart() {
        super.onStart()
        initPlayer()
    }

    override fun onPause() {
        releasePlayer()
        super.onPause()
    }

    override fun onStop() {
        releasePlayer()
        super.onStop()
        player?.stop()
    }
    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            mediaItemIndex = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }
}