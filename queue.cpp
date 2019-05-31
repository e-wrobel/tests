#include <iostream>
using namespace std;

template <class T>
class CustomQueue
{

public:
    int size;
    int push_index;
    int pop_index;
    T *tab;

    CustomQueue(int default_size)
    {
        size = default_size;
        push_index = 0;
        pop_index = 0;
        tab = new T[size];
    }

    void add(T e)
    {

        if (push_index < size)
        {
            tab[push_index++] = e;
        }
        else
        {
            cout << "tab overloaded, resizing!" << endl;

            // Create twice bigger array and copy everything from the new one
            T *temp = new T[2 * size];
            for (int i = 0; i < size; i++)
            {
                temp[i] = tab[i];
            }

            delete[] tab;
            tab = temp;
            
            size *= 2;

            tab[push_index++] = e;
        }
    }

    T remove()
    {
        if (pop_index < push_index)
        {
            return tab[pop_index++];
        }
        else
        {
            cout << "Queue is null." << endl;
            return NULL;
        }
    }

    bool isEmpty()
    {
        if (push_index == pop_index)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};

int main()
{
    CustomQueue<string> c = CustomQueue<string>(3);
    c.add("String1");
    c.add("String2");
    c.add("String3");
    c.add("String4");
    for (int i = 0; i < 4; i++) {
        cout << "Element " << i << ": " << c.remove() << " Queue empty: " << c.isEmpty() << endl;
    }

    return 0;
}
