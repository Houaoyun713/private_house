import request from '@/utils/request'

// 查询导则规范列表
export function listDard(query) {
  return request({
    url: '/dard/dard/list',
    method: 'get',
    params: query
  })
}

// 查询导则规范详细
export function getDard(id) {
  return request({
    url: '/dard/dard/' + id,
    method: 'get'
  })
}

// 新增导则规范
export function addDard(data) {
  return request({
    url: '/dard/dard',
    method: 'post',
    data: data
  })
}

// 修改导则规范
export function updateDard(data) {
  return request({
    url: '/dard/dard',
    method: 'put',
    data: data
  })
}

// 删除导则规范
export function delDard(id) {
  return request({
    url: '/dard/dard/' + id,
    method: 'delete'
  })
}
