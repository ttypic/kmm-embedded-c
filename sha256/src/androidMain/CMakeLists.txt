cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_C_STANDARD 99)

file(GLOB_RECURSE sources "../../native/*.c")

add_library(sha256 SHARED ${sources})

target_link_libraries(sha256)
