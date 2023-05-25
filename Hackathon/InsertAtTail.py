# Complete the insertNodeAtTail function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#5
# 141
# 302
# 164
# 530
# 474
#
#!/bin/python3

import math
import os
import random
import re
import sys

class SinglyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

def print_singly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)

def insertNodeAtTail(head, data):
    node = SinglyLinkedListNode(data)
    # if the head is empty, return the head as the node value
    if head is None:
        head = node
        return head
    # assign the head to a new value
    temp = head
    # as long as the next value is not empty, assign the current value to the next
    while temp.next is not None:
        temp =temp.next 
    # and at the end , when the next value is empty , assign it to the node, which adds it to the tail of ll.
    temp.next = node
    return head
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    llist_count = int(input())

    llist = SinglyLinkedList()

    for i in range(llist_count):
        llist_item = int(input())
        llist_head = insertNodeAtTail(llist.head, llist_item)
        llist.head = llist_head

    print_singly_linked_list(llist.head, '\n', fptr)
    fptr.write('\n')

    fptr.close()