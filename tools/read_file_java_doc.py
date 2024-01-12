#!/usr/bin/env python3

import sys
import os
import re
import codecs

#  * Leetcode. 269. Alien Dictionary
prefix = "lib/src/main/java/com/github/akovalchuk/"
pattern = r'.*Leetcode\. \d+\. (.+)$'

def read_files(path: str):
    for item in os.listdir(path):
        file_path = os.path.join(path, item)
        if os.path.isfile(file_path):
            with codecs.open(file_path, 'r', encoding='utf-8', errors='ignore') as file:
                for line in file.readlines():
                    m = re.match(pattern, line.strip())
                    if m:
                        print(f"1. [{m.group(1)}]({prefix}/{item})")

if __name__ == "__main__":
    args = sys.argv[1]
    read_files(args)