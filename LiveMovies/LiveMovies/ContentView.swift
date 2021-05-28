//
//  ContentView.swift
//  LiveMovies
//
//  Created by Jesús Antonio Pérez Reyes on 27/05/21.
//
//

import SwiftUI
import URLImage

struct ContentView: View {
    @ObservedObject var movieService = MovieService()
    var body: some View {
        NavigationView { List(movieService.movies, id: \.id) { movie in
            URLImage(url: (URL(string: "https://image.tmdb.org/t/p/w500/\(movie.poster_path)") ?? URL(string:
            "https://via.placeholder.com/80X100"))!) {
                image in image.resizable().clipped().frame(width: 80, height: 100, alignment: .center)
            }
            Text(movie.title)
        }}.onAppear(perform: {
            movieService.getData()
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
