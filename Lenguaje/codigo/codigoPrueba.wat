(module
 (type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $print (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $main)
(func $main  (type $_sig_void)
 (local $localsStart i32)
 (local $temp i32)
 i32.const 56
 call $reserveStack
 set_local $temp
 get_global $MP
 get_local $temp
 i32.store
 get_global $MP
 get_global $SP
 i32.store offset=4
 get_global $MP
 i32.const 8
 i32.add
 set_local $localsStart
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 0
i32.store
block
loop
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 5
i32.lt_s
i32.eqz
br_if 1
i32.const 4
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.mul
i32.const 0
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.add
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.store
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
br 0
end
end
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 5
i32.store
block
loop
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 10
i32.lt_s
i32.eqz
br_if 1
i32.const 4
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.mul
i32.const 0
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.add
i32.const 5
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.sub
i32.store
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
br 0
end
end
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 4
i32.const 0
i32.mul
i32.const 0
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.add
i32.load
i32.store
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 0
i32.store
block
loop
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 10
i32.lt_s
i32.eqz
br_if 1
i32.const 4
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.mul
i32.const 0
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.add
i32.load
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.gt_s
if
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 4
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.mul
i32.const 0
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.add
i32.load
i32.store
else
end
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.const 11
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
br 0
end
end
i32.const 10
i32.const 4
i32.mul
get_local $localsStart
i32.add
i32.load
call $print
 call $freeStack
)
(func $reserveStack (param $size i32)
  (result i32)
  get_global $MP
  get_global $SP
  set_global $MP
  get_global $SP
  get_local $size
  i32.add
  set_global $SP
)
(func $freeStack (type $_sig_void)
  get_global $MP
  i32.load
  i32.load offset=4
  set_global $SP
  get_global $MP
  i32.load
  set_global $MP
)
)
