//
//  MovieService.swift
//  LiveMovies
//
//  Created by Jesús Antonio Pérez Reyes on 27/05/21.
//
//

import Foundation

class MovieService: ObservableObject {
    @Published var movies = [MovieModel]()

//    Alternative of onAppear
//    init() {
//        getData()
//    }

    func getData () {
        guard let url = URL(string: "https://api.themoviedb.org/3/movie/popular?api_key=89db676e08b3729fa899366e9ee46f2f&language=en-US&page=1") else {
            return print("Error when creating the URL")
        }
        let session = URLSession(configuration: .default)
        let task = session.dataTask(with: url) { data, response, error in
            guard error == nil else {
                return print(error!)
            }
            guard let safeData = data else {
                return print(error!)
            }

            let decoder = JSONDecoder()
            let unsafeMovieList = try? decoder.decode(MovieList.self, from: safeData)
            guard let movieList = unsafeMovieList else {
                return print("Could not decode movie list")
            }

            DispatchQueue.main.async {
                self.movies = movieList.results;
            }
        }
        task.resume()
    }
}
