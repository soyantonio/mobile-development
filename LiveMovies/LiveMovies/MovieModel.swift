//
//  MovieModel.swift
//  LiveMovies
//
//  Created by Jesús Antonio Pérez Reyes on 27/05/21.
//
//

import Foundation

struct MovieList:Decodable {
    var results: [MovieModel]
}

struct MovieModel:Decodable {
    var id: Int
    var title: String
    var vote_average: Float
    var poster_path: String
}