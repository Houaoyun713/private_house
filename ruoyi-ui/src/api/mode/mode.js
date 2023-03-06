import request from '@/utils/request'

// 查询支持方式列表
export function listMode(query) {
  return request({
    url: '/mode/mode/list',
    method: 'get',
    params: query
  })
}

// 查询支持方式详细
export function getMode(id) {
  return request({
    url: '/mode/mode/' + id,
    method: 'get'
  })
}

// 新增支持方式
export function addMode(data) {
  return request({
    url: '/mode/mode',
    method: 'post',
    data: data
  })
}

// 修改支持方式
export function updateMode(data) {
  return request({
    url: '/mode/mode',
    method: 'put',
    data: data
  })
}

// 删除支持方式
export function delMode(id) {
  return request({
    url: '/mode/mode/' + id,
    method: 'delete'
  })
}
