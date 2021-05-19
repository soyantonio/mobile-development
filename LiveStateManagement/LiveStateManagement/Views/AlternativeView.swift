//
// Created by Jesús Antonio Pérez Reyes on 18/05/21.
//

import SwiftUI

struct AlternativeView: View {
    @Binding var state: String
    var body: some View {
        TextField("Hola", text: $state)
    }
}