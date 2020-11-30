/*
 * Copyright 2020 Johan Haleby
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.occurrent.example.domain.uno


sealed class Event {
    abstract val gameId: GameId
    abstract val timestamp: Timestamp
}

data class GameStarted(override val gameId: GameId, override val timestamp: Timestamp, val firstPlayerId: PlayerId, val playerCount: PlayerCount, val firstCard: Card) : Event()

data class CardPlayed(override val gameId: GameId, override val timestamp: Timestamp, val playerId: PlayerId, val card: Card, val nextPlayerId: PlayerId) : Event()

data class PlayerPlayedAtWrongTurn(override val gameId: GameId, override val timestamp: Timestamp, val playerId: PlayerId, val card: Card) : Event()

data class PlayerPlayedWrongCard(override val gameId: GameId, override val timestamp: Timestamp, val playerId: PlayerId, val card: Card) : Event()

data class DirectionChanged(override val gameId: GameId, override val timestamp: Timestamp, val direction: Direction) : Event()